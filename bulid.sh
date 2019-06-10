sudo fuser -k -n tcp 8082
sudo fuser -k -n tcp 8081
nohup java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8082  learn --server.port=8081 --spring.profiles.active=dev&
