# solution
- install groovy
- run with java, include groovy libs in classpath

```
java -cp . runme
Error: Could not find or load main class runme
Caused by: java.lang.NoClassDefFoundError: groovy/lang/Script

java -cp .:$GROOVY_HOME/lib/* runme
```