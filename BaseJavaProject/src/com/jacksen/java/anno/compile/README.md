
##编译时Annotation

编译时Annotation指@Retention为CLASS的Annotation，由编译器自动解析。

需要做的步骤：

- 自定义类继承AbstractProcessor
- 重写process方法


实际上编译器会在编译时自动查找所有继承AbastractProcessor的类。然后调用process方法处理。