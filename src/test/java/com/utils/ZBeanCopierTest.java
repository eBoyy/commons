package com.utils;

import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * Description: ZBeanCopierTest
 * Author: zhumengzhu
 * Create: 2015-12-03 11:11
 */
public class ZBeanCopierTest {

    @Before
    public void setProperty() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/tmp");
    }

    @Test
    public void copy() {
        ZBeanCopier copier = ZBeanCopier.create(MA.class, MA.class, false);
        MA from = new MA(42);
        from.setPrivateName("CP3");

        MA to = new MA();
        copier.copy(from, to, null);

        Assert.isTrue(to.getIntP() == 0);
        Assert.isTrue(to.getPrivateName() == null);
    }


    @Test
    public void simple() {
        ZBeanCopier copier = ZBeanCopier.create(FromBean.class, FromBean.class, false);

        FromBean from = FromBean.getDefault();
        FromBean to = new FromBean();

        copier.copy(from, to, null);
        Assert.isTrue(from.getIntValue() == to.getIntValue());
        System.out.println(to);
    }

    @Test
    public void oneWay() {
        ZBeanCopier copier = ZBeanCopier.create(GettersBean.class, SettersBean.class, false);

        GettersBean from = new GettersBean();
        SettersBean to = new SettersBean();

        copier.copy(from, to, null);

        System.out.println(to);
    }

    @Test
    public void toBuilderBean() {
        ZBeanCopier copier = ZBeanCopier.create(FromBean.class, BuilderBean.class, false);

        FromBean from = FromBean.getDefault();
        BuilderBean to = new BuilderBean();

        copier.copy(from, to, null);

        System.out.println(to);
    }

    @Test
    public void primitiveToRef() {
        ZBeanCopier copier = ZBeanCopier.create(PrimitiveBean.class, ReferenceBean.class, false);

        PrimitiveBean from = PrimitiveBean.getDefault();
        ReferenceBean to = new ReferenceBean();

        copier.copy(from, to, null);

        System.out.println(to);
    }

    @Test
    public void refToPrimitive() {
        ZBeanCopier copier = ZBeanCopier.create(ReferenceBean.class, PrimitiveBean.class, false);

        ReferenceBean from = ReferenceBean.getDefault();
        PrimitiveBean to = new PrimitiveBean();

        copier.copy(from, to, null);

        System.out.println(to);
    }

    @Test
    public void partialCopy() {
        ZBeanCopier copier = ZBeanCopier.create(ReferenceBean.class, PrimitiveBean.class, false);

        ReferenceBean from = new ReferenceBean();

        from.setLongValue(20L);
        from.setBoolValue(Boolean.TRUE);

        PrimitiveBean to = new PrimitiveBean();

        copier.copy(from, to, null);

        Assert.isTrue(from.getLongValue().equals(to.getLongValue()));
        Assert.isTrue(from.getBoolValue().equals(to.isBoolValue()));

        // from 值为 null 时, 不拷贝, 此处为默认值 -1
        Assert.isTrue(to.getIntValue() == -1);

        System.out.println(to);
    }


}
