这里记录Java中读取配置文件的三种方式:
   暂时定义三种方式
 1. 通过文件io流

``` InputStream in =ResourceDemo.class.getResourceAsStream("/mapper.xml");
           int len=0;
           byte[] bytes=new byte[1024];
           while ((len=in.read())!=-1){
               in.read(bytes,0,len);
           }
           System.out.println(bytes);
```
2. 再Spring中我们把这个方式称为统一资源加载，所有的类都继承或者实现Resource;
  统一资源Resource
  统一资源定位ResourceLoader-------------->资源加载策略被封装再DefaultResourceLoader类中,getResource已经被重新加载。
  ProtocolResolver用户定义协议解决策略，作为DefaultResourceLoader的SPI
  ------------------------------------------------------
  Resource getResource(String location)方法，每次根据location返回一个Resource。
  ResourcePatternResolver 是ResourceLoader的扩展，一次性能返回多个Resource
  PathMatchingResourcePatternResolver支持**/*.xml风格
  