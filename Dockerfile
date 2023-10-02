FROM openjdk:11-jre-slim
COPY build/libs/FitnessPaymentService2.jar /FitnessPaymentService2.jar
CMD ["java", "-jar", "/FitnessPaymentService2.jar"]