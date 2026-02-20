# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Run stage
FROM tomcat:10.1-jdk21

# Remove default ROOT app
RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Use Render dynamic port
ENV PORT=8080
EXPOSE 8080

CMD ["catalina.sh", "run"]