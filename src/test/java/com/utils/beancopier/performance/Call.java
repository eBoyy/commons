package com.utils.beancopier.performance;


import com.utils.beancopier.FromBean;

/**
 * Description: Call
 * Author: zhumengzhu
 * Create: 2015-12-04 17:39
 */
public interface Call {

    String getName();

    void call(FromBean bean);
}
