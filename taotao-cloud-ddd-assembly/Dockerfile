FROM registry.cn-hangzhou.aliyuncs.com/taotao-cloud-project/taotao-cloud-openjdk21:latest as builder
#FROM registry.cn-hangzhou.aliyuncs.com/taotao-cloud-project/taotao-cloud-graalvm21:latest as builder

WORKDIR /root

ADD ./build/libs/taotao-cloud-ddd-2025.07.jar ./

#RUN java -Djarmode=layertools -jar taotao-cloud-ddd-2025.07.jar extract

RUN java -Djarmode=tools -jar taotao-cloud-ddd-2025.07.jar extract --layers --destination extracted

# FROM registry.cn-hangzhou.aliyuncs.com/taotao-cloud-project/taotao-cloud-skywalking:openjdk-17-8.6.0
# FROM registry.cn-hangzhou.aliyuncs.com/taotao-cloud-project/taotao-cloud-openjdk21:amd64
#FROM registry.cn-hangzhou.aliyuncs.com/taotao-cloud-project/taotao-cloud-openjdk21-skywalking-9-3-0:latest
FROM registry.cn-hangzhou.aliyuncs.com/taotao-cloud-project/taotao-cloud-openjdk21-skywalking-9-3-0:latest

ARG BACKEND_SERVICE=192.168.218.2:11800
ARG AGENT_AUTHENTICATION=taotao-cloud
ARG APP_NAME=taotao-cloud-ddd
ARG APP_VERSION=2025.07
ARG JAR=${APP_NAME}-${VERSION}
ARG JAR_NAME=${JAR}.jar
ARG APP_PORT=33331
ARG PRROFILES=dev

LABEL application_name=${APP_NAME}
LABEL application_version=${APP_VERSION}
LABEL org.opencontainers.image.authors=981376577@qq.com

ENV TZ=Asia/Shanghai
ENV APP_NAME=${APP_NAME}
ENV VERSION=${APP_VERSION}
ENV JAR_NAME=${APP_NAME}-${VERSION}.jar
ENV BACKEND_SERVICE=${BACKEND_SERVICE}
ENV AGENT_AUTHENTICATION=${AGENT_AUTHENTICATION}
ENV TAOTAO_CLOUD_MAIL_PASSWORD=${TAOTAO_CLOUD_MAIL_PASSWORD}
ENV PRROFILES=${PRROFILES}
ENV JAVA_OPTIONS="-Xms1g \
                  -Xmx2g \
                  -Xss256k \
                  -XX:ReservedCodeCacheSize=2048m \
                  -XX:+UseZGC \
                  -XX:MaxDirectMemorySize=256m \
                  -XX:SoftRefLRUPolicyMSPerMB=50 \
                  -XX:CICompilerCount=2  \
                  -XX:SurvivorRatio=8 \
                  -XX:+UseCompressedOops \
                  -XX:+UseCompressedClassPointers \
                  -XX:+SegmentedCodeCache \
                  -XX:+PrintCommandLineFlags \
                  -XX:+ExplicitGCInvokesConcurrent \
                  -XX:-OmitStackTraceInFastThrow\
                  -XX:+HeapDumpOnOutOfMemoryError \
                  -XX:+ShowCodeDetailsInExceptionMessages \
                  -XX:ParallelGCThreads=4 \
                  -Xlog:async \
                  -XX:AsyncLogBufferSize=409600 \
                  -Xlog:gc*=debug:file=/root/logs/${APP_NAME}/${APP_NAME}.gc.log:utctime,level,tags:filecount=50,filesize=100M \
                  -Xlog:jit+compilation=debug:file=/root/logs/${APP_NAME}/${APP_NAME}.jit.compile.log:utctime,level,tags:filecount=10,filesize=100M \
                  -XX:MetaspaceSize=256m \
                  -XX:MaxMetaspaceSize=256m \
                  -verbose:gc \
                  -Djava.security.egd=file:/dev/./urandom \
                  -Dfile.encoding=utf-8 \
                  --add-opens java.base/java.lang=ALL-UNNAMED \
                  --add-opens java.base/java.lang.reflect=ALL-UNNAMED \
                  --add-opens java.base/java.util=ALL-UNNAMED \
                  --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED \
                  -Dspring.profiles.active=${PRROFILES} \
                  -javaagent:/skywalking/agent/skywalking-agent.jar \
                  -Dskywalking.agent.service_name=${APP_NAME} \
                  -Dskywalking.agent.authentication=${AGENT_AUTHENTICATION} \
                  -Dskywalking.logging.file_name=skywalking.log \
                  -Dskywalking.logging.level=INFO \
                  -Dskywalking.logging.dir=/root/logs/${APP_NAME} \
                  -Dskywalking.collector.backend_service=${BACKEND_SERVICE} "

ENV CDS_JAVA_OPTIONS = "${JAVA_OPTIONS} -XX:SharedArchiveFile=taotao-cloud-ddd.jsa"

USER root

WORKDIR /root

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime \
    && echo $TZ > /etc/timezone \
    && mkdir -p /root/logs/${APP_NAME} \
    && touch /root/logs/${APP_NAME}/${APP_NAME}.jit.compile.log /root/logs/${APP_NAME}/${APP_NAME}.gc.log \
    && sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories \
    && apk add curl

VOLUME /root/logs

EXPOSE ${APP_PORT}

COPY --from=builder /root/extracted/dependencies/ ./
RUN true
COPY --from=builder /root/extracted/spring-boot-loader/ ./
RUN true
COPY --from=builder /root/extracted/snapshot-dependencies/ ./
RUN true
COPY --from=builder /root/extracted/application/ ./
RUN true

HEALTHCHECK --interval=120s --timeout=60s --retries=5 CMD curl -fs http://192.168.218.2:${APP_PORT}/actuator/health || exit 1

#ENTRYPOINT sleep 30; java ${JAVA_OPTIONS} org.springframework.boot.loader.JarLauncher

#cds
#https://docs.spring.io/spring-boot/reference/packaging/class-data-sharing.html
#https://docs.spring.io/spring-boot/reference/packaging/container-images/dockerfiles.html
RUN java -XX:ArchiveClassesAtExit=taotao-cloud-ddd.jsa -Dspring.context.exit=onRefresh -jar taotao-cloud-ddd-2025.07.jar

#ENTRYPOINT sleep 30; java ${CDS_JAVA_OPTIONS} -jar taotao-cloud-ddd-2025.07.jar

ENTRYPOINT ["java", "${CDS_JAVA_OPTIONS}", "-jar", "taotao-cloud-monitor-2025.07.jar"]
