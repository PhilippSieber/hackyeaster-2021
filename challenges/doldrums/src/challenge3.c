#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

char verse1[] = "Hear the rime of the ancient mariner\nSee his eye as he stops one of three\nMemmerizes one of the wedding guests\nStay here and listen to the nightmares of the sea\n\n";
char verse2[] = "And the music plays on, as the bride passes by\nCaught by his spell and the mariner tells his tale\n\n";
char verse3[] = "Driven south to the land of the snow and ice\nTo a place where nobody's been\nThrough the snow fog flies on the albatross\nHailed in God's name, hoping good luck it brings\n\n";
char verse4[] = "And the ship sails on, back to the North\nThrough the fog and ice and the albatross follows on\n\n";
char verse5[] = "The mariner kills the bird of good omen\nHis shipmates cry against what he's done\nBut when the fog clears, they justify him\nAnd make themselves a part of the crime\n\n";
char verse6[] = "Sailing on and on and north across the sea\nSailing on and on and north 'til all is calm\n\n";
char verse7[] = "The albatross begins with its vengeance a terrible curse a thirst has begun\nHis shipmates blame bad luck on the mariner\nAbout his neck, the dead bird is hung\n\n";
char verse8[] = "And the curse goes on and on at sea\nAnd the curse goes on and  on for them and me\n\n";
char dayAfterDay[] = "\"Day after day, day after day\nWe stuck nor breath nor motion\nAs idle as a painted ship upon a painted ocean\nWater, water, everywhere and\nAll the boards did shrink\nWater, water everywhere nor any drop to drink\"\n\n";

char weblink[] = "More info? https://en.wikipedia.org/wiki/The_Rime_of_the_Ancient_Mariner\n";

int main(int argc, char **argv) 
{
	char dummy[] = "\x00\x00\x00\x00";
	ignore_me_init_buffering();
	ignore_me_init_signal();

	printf("Welcome! Here is a nice rime of the poet Samuel Taylor Coleridge for you!\n");
	printf("Please press a key to continue!\n\n");
	gets(dummy);
	system("/bin/cat ./heading");
	printf("-------------------------------------------------------\n");
	printf("%s%s%s%s%s%s%s%s%s\n\n%s\n", verse1,verse2,verse3,verse4,verse5,verse6,verse7,verse8,dayAfterDay,weblink);
}
__attribute__((used))
void remove_me_before_deploy()
{
	asm("pop %edi\nret\n");
	asm("pop %esi\nret\n");
	asm("xor %eax,%eax\nret\n");
	asm("movl %edx, (%edi)\nret\n");
	asm("movl (%esi), %edx\nret\n");
}

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

