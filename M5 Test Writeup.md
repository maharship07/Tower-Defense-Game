M5 Tests

Ian Westcott:
    tower1AttackTest():
        This tests checks the attack method of Tower 1, the standard projectile tower, against a list of enemies, some in range and some out of range. The tests checks to make sure the tower attacks only the enemy furthest along the path that is within range of the tower. Thus, the test makes ensures that combat function of tower 1 works correctly, only attacking enemies within range and only attacking a single enemy at a time.
    tower2AttackTest():
        This tests checks the attack method of Tower 2, the AOE tower, against a list of enemies, some in range and some out of range. The tests checks to make sure the tower attacks every enemy in range of the tower. Thus, the test makes ensures that combat function of tower 1 works correctly, only attacking enemies within range and preforming its function of damaging every enemy in range.
Manu Gupta:
    testTowerFactoryPosition(): 
        This test checks whether the tower factory class correctly instantiates tower instances to have the correct location. It does this by testing a few dummy values for all the tower classes. 

    testTowerFactoryType():
        This test checks whether the tower factory class correctly instantiates the correct tower when different values of diff are passed in. It does this by testing the damage and range values of each 
tower when created 
         
