# Question Box Clone

## OpenAPI documentation

- nginx を起動し、 ReDoc CDN を利用して OpenAPI をホスト 

```shell
docker-compose -f openapi/docker-compose.yaml up -d 

$ docker-compose -f openapi/docker-compose.yaml ps
   
       Name                     Command               State          Ports        
----------------------------------------------------------------------------------
question-box-nginx   /docker-entrypoint.sh ngin ...   Up      0.0.0.0:9000->80/tcp
```

- [http://localhost:9000/ にアクセス](http://localhost:9000/)

- 終了する際

```shell
docker-compose -f openapi/docker-compose.yaml down
```

---
## Run local

- set jdk 11

```shell
export JAVA_HOME=`/usr/libexec/java_home -v 11`

java -version
```

- run MySQL

```shell
docker-compose up -d
```

- run application as a spring-boot

```shell
./mvnw spring-boot:run
```
