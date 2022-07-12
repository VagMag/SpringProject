../liquibase/liquibase \
    --driver=org.postgresql.Driver \
    --classpath=.. \
    --changeLogFile=../db/changelog-master.xml\
    --url="jdbc:postgresql://localhost:5432/testdb" \
    --username=maximvagin \
    --password=123 \
    update