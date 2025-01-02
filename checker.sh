#/bin/bash

CLASSPATH=./build:antlr.jar

passed=0
for source_file in ./tests/tema3/*.cl; do
	echo -e "\n`basename $source_file`"
	java -cp $CLASSPATH cool.compiler.Compiler $source_file > ./tests/tema3/`basename $source_file .cl`.s
	if [ "$source_file" = "./tests/tema3/32-big.cl" ]; then
		echo 5 | spim -exception_file trap.handler.nogc -file tests/tema3/`basename $source_file .cl`.s > tests/tema3/`basename $source_file .cl`.out
	else
		spim -exception_file trap.handler.nogc -file tests/tema3/`basename $source_file .cl`.s > tests/tema3/`basename $source_file .cl`.out
	fi

	diff tests/tema3/`basename $source_file .cl`.ref tests/tema3/`basename $source_file .cl`.out

	if [ $? = 0 ]; then
		echo -e "Test passed!\n"
		passed=$(($passed + 1))
	else	
		echo -e "Test failed!\n"
	fi
done

echo -e "\nTotal: $(( $(($passed * 100)) / 32))"
