exec java -cp app:app/lib/* -server -XX:+HeapDumpOnOutOfMemoryError -XX:+UnlockExperimentalVMOptions $JAVA_OPTS $*