
run: Main.class
	java Main

Main.class: 
	javac Main.java

clean:
	rm -rf animals/*
	rm ./*.class