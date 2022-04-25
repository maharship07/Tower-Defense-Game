M6 Tests:
Manu Gupta:
    upgradeDamageTest():
        This test checks whether upgrading a tower increases the damage as expected. Because towers should only be able to be upgraded once, this test
        also checks what happens when an upgrade is attempted on a tower twice.

    upgradeRangeTest()
       This test checks whether using the range upgrade will double the range as expected. Since towers can only be upgraded once, this test also verifies
       that the tower doesn't upgrade its range again after its been doubled once already.

Vedant Amin:
    testGameWinScreen():
        This tests checks whether the game transitions to the game_win_screen when the towers eliminates the final boss.

    bossDamageMonument():
        This tests checks if the final boss can attack the monument and whether the monument takes damages or not and after attacking
        if the health decreases to zero.

Ian Westcott:
    enemiesKilledTest():
        This test checks to make sure the enemies killed statistic, one of the statistics required to be displayed on game end, updates correctly. This is done by calling the removeDeadEnemies() method and checking whether the method correctly updates the statistic based on the number of dead enemies in the enemy array.
    totalDamageTakenTest():
        This test checks to make sure the total damage taken statistic, another one of the statistic required to be displayed on game end, updates correctly. This is done by calling the attack method for each of the types of normal enemies and checking whether the total damage taken statistic equals the sum of the damage of each enemy.