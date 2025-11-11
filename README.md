
How to run the unit tests for range summariser

# From the project root directory

# 1️⃣ Compile all Java files
javac -cp ".;libs\junit-platform-console-standalone-1.10.0.jar" src\numberrangesummarizer\*.java

# 2️⃣ Run all JUnit 5 tests
java -jar libs\junit-platform-console-standalone-1.10.0.jar -cp "src" --scan-class-path

On Linux / macOS, replace .; with .: in the -cp option, and \ with / in paths:

javac -cp ".:libs/junit-platform-console-standalone-1.10.0.jar" src/numberrangesummarizer/*.java
java -jar libs/junit-platform-console-standalone-1.10.0.jar -cp "src" --scan-class-path

Authored by Matthew van Helsdingen
