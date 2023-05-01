# Makefile file

CC = gcc

CFLAGS = -g -Wall $(INCLUDES)
CXXFLAGS = -g -Wall $(INCLUDES)
LDFLAGS = -g
LDLIBS = -lc -lm

main: main.o gcd.o

main.o: main.c gcd.h

gcd.o: gcd.c gcd.h

.PHONY: clean
clean:
    rm -f *.0 a.out core main

.PHONY: all
all: clean main
