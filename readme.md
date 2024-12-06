# name.ncg777
Some of these apps may be considered experimental or may contain unusual terminology.

First, you should extract the zip file wherever you want and add the path to the jar file to your CLASSPATH environment variable.

To run the main menu application that lets one open the apps with graphical interfaces, run the name.ncg777.sh script.

# Enumeration Scripts Documentation
Arguments' names cannot be specified and are just determined positionally at the moment.

The int[] type is printed like 1 level JSON integer arrays and can be parsed from space-joined integer strings (ex: "1 2 3") or JSON array-like strings (ex: "[1, 2, 3]").

## bitsequences.sh
- **Class**: name.ncg777.mathematics.enumerations.BitSequenceEnumeration
- **Parameters**: 
  - `n` (int): The size of the bit sequences.
  
## bitsets.sh
- **Class**: name.ncg777.mathematics.enumerations.BitSetEnumeration
- **Parameters**: 
  - `n` (int): The size of the bit sets.

## combinations.sh
- **Class**: name.ncg777.mathematics.enumerations.CombinationEnumeration
- **Parameters**: 
  - `n` (int): The size of the set.
  - `k` (int): The size of the subsets.

## compositions.sh
- **Class**: name.ncg777.mathematics.enumerations.CompositionEnumeration
- **Parameters**: 
  - `n` (int): The integer to be partitioned.

## crossingpartitions.sh
- **Class**: name.ncg777.mathematics.enumerations.CrossingPartitionEnumeration
- **Parameters**: 
  - `n` (int): The size of the crossing partitions.
   
## dyckwords.sh
- **Class**: name.ncg777.mathematics.enumerations.DyckWordEnumeration
- **Parameters**: 
  - `nbOfPairs` (int): The number of pairs of parentheses.

## fixedsetpartitions.sh
- **Class**: name.ncg777.mathematics.enumerations.FixedSetPartitionEnumeration
- **Parameters**: 
  - `n` (int) : The size of the set.
  - `k` (int) : The number of blocks.

## kpermutations.sh
- **Class**: name.ncg777.mathematics.enumerations.KPermutationEnumeration
- **Parameters**: 
  - `n` (int): The size of the set.
  - `k` (int): The size of the permutations.

## metacompositons.sh
- **Class**: name.ncg777.mathematics.enumerations.MetaCompositionEnumeration
- **Parameters**: 
  - `s` (String): The String to metacompose.
  - [`transform`] (boolean): transform the string (purpose yet unknown).
  
## mixedradices.sh
- **Class**: name.ncg777.mathematics.enumerations.MixedRadixEnumeration
- **Parameters**: 
  - `base` (int[]) : The base for the mixed radix enumeration.

## ngoodpaths.sh
- **Class**: name.ncg777.mathematics.enumerations.NGoodPathEnumeration
- **Parameters**: 
  - `n` (int) : n

## noncrossingpartitions.sh
- **Class**: name.ncg777.mathematics.enumerations.NonCrossingPartitionEnumeration
- **Parameters**: 
  - `n` (int): The size of the non-crossing partitions.
    
## permutations.sh
- **Class**: name.ncg777.mathematics.enumerations.PermutationEnumeration
- **Parameters**: 
  - `n` (int) : n
  
## regularlanguage.sh
- **Class**: name.ncg777.mathematics.enumerations.RegexEnumeration
- **Parameters**:
  - `regex` (String) : the regular expression to enumerate
  - [`stopAt`] (int) : the maximum number of elements to enumerate (-1 for no limit)
  - [`maxLength`] (int) : the maximum length of strings to generate
  
## setpartitions.sh
- **Class**: name.ncg777.mathematics.enumerations.SetPartitionEnumeration
- **Parameters**: 
  - `n` (int) : Size of partition.

## weakcompositions.sh
- **Class**: name.ncg777.mathematics.enumerations.WeakCompositionEnumeration
- **Parameters**: 
  - `n` (int) : Total.
  - `k` (int) : Number of summands.

## weakorders.sh
- **Class**: name.ncg777.mathematics.enumerations.WeakOrdersEnumeration
- **Parameters**: 
  - `n` (int) : Size of ordering.
  
## words.sh
- **Class**: name.ncg777.mathematics.enumerations.WordEnumeration
- **Parameters**: 
  - `length` (int) : Length of word.
  - `size` (int) : Size of alphabet.

## wordpermutations.sh
- **Class**: name.ncg777.mathematics.enumerations.WordPermutationEnumeration
- **Parameters**: 
  - `rk` (int[]) : List of the number of occurences of each element. The sum of this list will be the length of the output lists.

---
This application was compiled with Microsoft's build of OpenJDK 21.