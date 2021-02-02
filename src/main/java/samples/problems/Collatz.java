package samples.problems;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Collatz {

    public void runCollatzUntilOne(int num) {
        log.info("=======STARTING PROGRAM=======");
        boolean run = true;

        while (run) {
            log.info("{}", num);
            if (num == 1)
                run = false;

            num = collatz(num);
        }

        log.info("=======ENDING PROGRAM=======");
    }

    public Integer collatz(int doodoo) {
        int result;

        if (doodoo % 2 == 0) {
            result = doodoo / 2;
        } else {
            result = 3 * doodoo + 1;
        }

        return result;
    }

}
