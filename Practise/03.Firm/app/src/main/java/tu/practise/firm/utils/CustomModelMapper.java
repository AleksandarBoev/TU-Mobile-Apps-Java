package tu.practise.firm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomModelMapper {
    //TODO get all the getters. Remove "get" part and voala - I have the field name and value
    //TODO Get all the setters. Remove the "set". Match the get thingy with the set one and invoke setter.

    /**
     * Uses getters from "mapFrom" to get values and and setters from "mapTo" to set values.
     * <br/>
     * <br/>
     * Example: "setLastName" will try to get a value from "getLastName"
     * @param mapFrom object to be mapped from
     * @param mapTo object to be mapped to
     * @return set of names of setters from "mapTo", which were not invoked. If all
     * setters were used, the result will be an empty set.
     */
    public static Set<String> map(Object mapFrom, Object mapTo) {
        try {
            Map<String, Method> mapFromGetters = new HashMap<>();
            Map<String, Method> mapToSetters = new HashMap<>();

            Method[] mapFromMethods = mapFrom.getClass().getDeclaredMethods(); //api level 15, no streams
            for (Method method : mapFromMethods) {
                if (method.getName().startsWith("get")) {
                    method.setAccessible(true);
                    mapFromGetters.put(method.getName().substring(3), method);
                }
            }

            Method[] mapToMethods = mapTo.getClass().getDeclaredMethods();
            for (Method method : mapToMethods) {
                if (method.getName().startsWith("set")) {
                    method.setAccessible(true);
                    mapToSetters.put(method.getName().substring(3), method);
                }
            }

            Set<String> unusedSetters = new HashSet<>();
            for (Map.Entry<String, Method> mapToSettersKvp : mapToSetters.entrySet()) {
                String setterFieldName = mapToSettersKvp.getKey();
                if (!mapFromGetters.containsKey(setterFieldName)) {
                    unusedSetters.add(setterFieldName);
                } else {
                    mapToSettersKvp.getValue().invoke(mapTo, mapFromGetters.get(setterFieldName).invoke(mapFrom));
                }
            }

            return unusedSetters;
        } catch (Exception e) {
            return null;
        }
    }
}
