#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

void ignore_me_init_buffering() {
	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stdin, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);
}

void kill_on_timeout(int sig) {
  if (sig == SIGALRM) {
  	printf("[!] Anti DoS Signal. Patch me out for testing.");
    _exit(0);
  }
}

void ignore_me_init_signal() {
	signal(SIGALRM, kill_on_timeout);
	alarm(60);
}

int main(int argc, char **argv) 
{
	char name[20];
	ignore_me_init_buffering();
	ignore_me_init_signal();

	printf("Welcome! Please give me your name!\n> ");
	gets(name);
	printf("Hi %s, nice to meet you!\n", name);
}
__attribute__((used))
void profit()
{
	system("/bin/sh");
}
