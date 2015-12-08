# 一个 Bean 拷贝的工具类
- 扩展了 cglib 的 BeanCopier 工具类, 支持 primitive 类型和 Reference 类型的属性互相拷贝

- 获取 Bean 的 PropertyDescriptor 数组部分, 目前用的是 Spring 的 BeanUtils, 需要手写一个
