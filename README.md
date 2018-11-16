# springboot-03-data-jdbc-druid
## springboot整合jdbc+druid（阿里连接池）
### 注意
    配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    filters: stat,wall,slf4j 
    springboot2.0中日志中用的slf4j，不能写成log4j （网上很多教程springboot1.5.x的教程，写的是log4g，springboot2.0用会报错）
### 启动
    改自己的yml配置文件（mysql连接哪里--连接自己的mysql数据库，其中mysql,5.x与8.x不一样，如果报错，就加上参数，或者去掉参数，最好百度）
    第一个测试：再测试下允许测试代码，查看连接池是否是阿里的连接池（druid）
    第二个测试：正式启动代码，然后访问druid的监控地址，我代码写的是http://localhost/druid
    代码中设置登陆用户名：root
    密码：admin
    个人想改，自行设置即可
