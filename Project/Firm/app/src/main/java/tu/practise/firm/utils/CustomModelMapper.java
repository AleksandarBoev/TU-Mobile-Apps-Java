package tu.practise.firm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomModelMapper {
    /**
     * Uses getters from "mapFrom" to get values and and setters from "mapTo" to set values.
     * <br/>
     * <br/>
     * Example: "setLastName" will try to get a value from "getLastName"
     * @param sourceObject object to be mapped from
     * @param destinationObject object to be mapped to
     * @return set of names of setters from "mapTo", which were not invoked. If all
     * setters were used, the result will be an empty set.
     */
    public static Set<String> map(Object sourceObject, Object destinationObject) {
        try {
            Map<String, Method> sourceGetters = new HashMap<>();
            Map<String, Method> destinationSetters = new HashMap<>();

            Method[] sourceMethods = sourceObject.getClass().getDeclaredMethods(); //api level 15, no streams
            for (Method method : sourceMethods) {
                if (method.getName().startsWith("get")) {
                    method.setAccessible(true);
                    sourceGetters.put(method.getName().substring(3), method);
                }
            }

            Method[] destinationMethods = destinationObject.getClass().getDeclaredMethods();
            for (Method method : destinationMethods) {
                if (method.getName().startsWith("set")) {
                    method.setAccessible(true);
                    destinationSetters.put(method.getName().substring(3), method);
                }
            }

            Set<String> unusedSetters = new HashSet<>();
            for (Map.Entry<String, Method> currentDestinationSetter : destinationSetters.entrySet()) {
                String setterFieldName = currentDestinationSetter.getKey();

                if (!sourceGetters.containsKey(setterFieldName)) {
                    unusedSetters.add(setterFieldName);
                } else {
                    Object sourceGetterValue = sourceGetters.get(setterFieldName).invoke(sourceObject);
                    currentDestinationSetter.getValue().invoke(destinationObject, sourceGetterValue);
                }
            }

            for (Method destinationMethod : destinationMethods)
                destinationMethod.setAccessible(false);

            for (Method sourceMethod : sourceMethods)
                sourceMethod.setAccessible(false);

            return unusedSetters;
        } catch (Exception e) {
            return null;
        }
    }
}
