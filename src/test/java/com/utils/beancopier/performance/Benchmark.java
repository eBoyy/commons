package com.utils.beancopier.performance;

import com.utils.beancopier.FromBean;
import com.utils.ZBeanCopier;
import net.sf.cglib.beans.BeanCopier;

/**
 * Description: Benchmark
 * Author: zhumengzhu
 * Create: 2015-12-04 17:34
 */
public class Benchmark {

    private static final int THOUSAND = 1000;

    private static Call GET_SET = new Call() {
        @Override
        public String getName() {
            return "Get&Set";
        }

        @Override
        public void call(FromBean bean) {
            FromBean to = new FromBean();
            to.setIntValue(bean.getIntValue());
            to.setLongValue(bean.getLongValue());
            to.setFloatValue(bean.getFloatValue());
            to.setDoubleValue(bean.getDoubleValue());
            to.setShortValue(bean.getShortValue());
            to.setByteValue(bean.getByteValue());
            to.setCharValue(bean.getCharValue());
            to.setBoolValue(bean.isBoolValue());
            to.setIntegerValue(bean.getIntegerValue());
            to.setLongObjValue(bean.getLongObjValue());
            to.setFloatObjValue(bean.getFloatObjValue());
            to.setDoubleObjValue(bean.getDoubleObjValue());
            to.setShortObjValue(bean.getShortObjValue());
            to.setByteObjValue(bean.getByteObjValue());
            to.setStringValue(bean.getStringValue());
            to.setBigIntegerValue(bean.getBigIntegerValue());
            to.setBigDecimalValue(bean.getBigDecimalValue());
        }
    };

    private static Call BEAN_COPIER = new Call() {
        private BeanCopier copier = BeanCopier.create(FromBean.class, FromBean.class, false);

        @Override
        public String getName() {
            return "BeanCopier";
        }

        @Override
        public void call(FromBean bean) {
            FromBean to = new FromBean();
            copier.copy(bean, to, null);
        }
    };

    private static Call ZBENA_COPIER = new Call() {
        private ZBeanCopier mBeanCopier = ZBeanCopier.create(FromBean.class, FromBean.class, false);

        @Override
        public String getName() {
            return "ZBeanCopier";
        }

        @Override
        public void call(FromBean bean) {
            FromBean to = new FromBean();
            mBeanCopier.copy(bean, to, null);
        }
    };

    private static void benchmark(Call callable, FromBean bean, int counts) {

        long startTime = System.nanoTime();
        for (int i = 0; i < counts; i++) {
            callable.call(bean);
        }
        long totalTime = System.nanoTime() - startTime;

        System.out.println("name: " + callable.getName() +
                ", counts: " + counts +
                ", time: " + totalTime / (1000 * 1000) +
                " ms, average: " + totalTime / counts + " ns");

    }

    private static void run(int counts) {
        benchmark(ZBENA_COPIER, FromBean.getDefault(), counts);
        benchmark(BEAN_COPIER, FromBean.getDefault(), counts);
        benchmark(GET_SET, FromBean.getDefault(), counts);
    }

    public static void main(String[] args) {
        run(100 * THOUSAND);
    }

}
