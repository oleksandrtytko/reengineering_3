# reengineering_3

**Initial code** memory allocations:

![image](https://github.com/oleksandrtytko/reengineering_3/assets/124786943/f95dfa5e-142d-4472-bee1-f5cff29bc4e7)

![image](https://github.com/oleksandrtytko/reengineering_3/assets/124786943/dcb7421c-9cfc-4cc0-a9b1-621cdd41fc93)

Duration:

![image](https://github.com/oleksandrtytko/reengineering_3/assets/124786943/36d8879e-cb41-43ef-9acb-4c266cc0fa4a)


**Reengineered code** memory allocations:

![image](https://github.com/oleksandrtytko/reengineering_3/assets/124786943/321222ee-33fd-4a5d-813c-0678a6bb3fd7)

![image](https://github.com/oleksandrtytko/reengineering_3/assets/124786943/ad5d0cd9-f304-4263-b2c7-f771ad3d00df)

Duration:

![image](https://github.com/oleksandrtytko/reengineering_3/assets/124786943/8756d1e2-aac1-4c90-b227-dfac1006f13d)

Reengineered code steps:
1. Read every byte of the text.
2. Determine if a currrent byte is a letter or not.
3. If a byte is not a letter then assume that previous collected bytes formed a word.
4. Add current word to a hashmap or increment value of the hashmap. 
