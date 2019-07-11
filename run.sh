find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java -cp src com.jding05.avaj_launcher.simulator.Simulator src/scenario.txt
