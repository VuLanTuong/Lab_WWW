// application properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mariadb://localhost:3306/lab7ck?createDatabaseIfNotExist=true 
spring.datasource.username=root
spring.datasource.password=sapassword
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.main.allow-circular-references=true

// schema.sql
create table if not exists  users
(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled  boolean not null
    );

create table if not exists authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
    );
create unique index if not exists ix_auth_username on authorities (username, authority);


//dependece
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6'
    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.springframework.security:spring-security-test'
    implementation 'com.thedeanda:lorem:2.2'
