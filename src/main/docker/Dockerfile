FROM centos
MAINTAINER chenkuan "kuanchen@kejiatc.cn"
#创建目录
RUN mkdir -p /home/software/java/jdk1.7.0_79
ADD jdk1.7.0_79 /home/software/java/jdk1.7.0_79
ADD mogateways-0.0.1.jar /home/software/mogateways-0.0.1.jar
#添加环境变量
ENV JAVA_HOME /home/software/java/jdk1.7.0_79
ENV PATH $PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin
ENV LD_LIBRARY_PATH $LD_LIBRARY_PATH:/home/software/java/jdk1.7.0_79/bin
ENV LANG C.UTF-8
#暴露端口
EXPOSE 80
#启动时运行
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/software/mogateways-0.0.1.jar"]