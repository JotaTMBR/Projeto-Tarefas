FROM openjdk:17
EXPOSE 8095
ADD target/tarefas.jar tarefas.jar
ENTRYPOINT ["java","-jar","tarefas.jar"]