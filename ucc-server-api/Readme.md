### 备注关于ResourceLoader读取文件的一些问题
这里发生了一个弱智的问题，我在使用ClassPathLoader的时候，我是用ClassPathLoader去读取mybatis-config.xml文件的时候我使用clsspath:/开头，
导致程序报错，查看ClassPathResource构造方法，我发现
```String pathToUse = StringUtils.cleanPath(path);
   		if (pathToUse.startsWith("/")) {
   			pathToUse = pathToUse.substring(1);
   		}
```
我去，这是一种很日的赶脚。所以我写了一篇关于类加载机制的文章,当然由于最开始我没找到错误我是用了DefaultResourceLoader类
```
if (location.startsWith("/")) {
			return getResourceByPath(location);
		}
		else if (location.startsWith(CLASSPATH_URL_PREFIX)) {
			return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()), getClassLoader());
		}
```
因为这里有判断，我日，这是我运气比较好，碰巧预上了else。
1. 我先说文件系统的两种文件定位方式
  1. / 表示绝对路径
  2. 表示相对路径
-------------------------------------------------------------------------------------
Java中读取配置文件的几种方式:详见ucc-server-api中的com.ytravler.demo.resourcedemo。
-------------------------------------------------------------------------------------
spring加载文件的体系结构以及方式:
 详见com.ytravler.demo.spring.resourcedemo
-----------------------------------------------------------------------------------------------
 
 
 

  