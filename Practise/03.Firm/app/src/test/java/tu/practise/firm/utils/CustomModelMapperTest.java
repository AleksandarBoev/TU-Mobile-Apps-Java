package tu.practise.firm.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tu.practise.firm.utils.CustomModelMapper;

public class CustomModelMapperTest {
    private static final int ID = 1;
    private static final String NAME = "Pesho";
    private static final long EGN = 1001L;

    private Class1 class1Obj;

    @Before
    public void init() {
        class1Obj = new Class1(ID, NAME, EGN);
    }

    @Test
    public void testMapping() {
        Class2 class2Obj = new Class2();
        CustomModelMapper.map(class1Obj, class2Obj);

        Assert.assertEquals(class1Obj.getName(), class2Obj.getName());
        Assert.assertEquals(class1Obj.getEgn(), class2Obj.getEgn());
    }

    public class Class1 {
        int id;
        String name;
        long egn;

        public Class1(int id, String name, long egn) {
            this.id = id;
            this.name = name;
            this.egn = egn;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public long getEgn() {
            return egn;
        }
    }

    public class Class2 {
        String name;
        long egn;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getEgn() {
            return egn;
        }

        public void setEgn(long egn) {
            this.egn = egn;
        }
    }
}
