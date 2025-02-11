### Hexlet tests and linter status:
[![Actions Status](https://github.com/nika7407/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/nika7407/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/e0ae8ce96eca97f1b54a/maintainability)](https://codeclimate.com/github/nika7407/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/e0ae8ce96eca97f1b54a/test_coverage)](https://codeclimate.com/github/nika7407/java-project-78/test_coverage)

# Validator 
you can use validator class to create parametrized checks 
and then use them however you want. :)
Use Validator class to access all to access all different methods.

` Validator v = new Validator();`

use method on your parameter settings

` .isValid( *yourData* )`

to check the yourData with chosen parameters



Validator supports:
**Strings**,
**Maps** and
**Numbers**
## Numbers
> v.number()

* **required** parameter makes null value false 
* **range** parameter creates range requirement from and to (including from and to)
* **positive** parameter ensures that number is ~~obviously~~ positive

`v.number().required();`

`v.number().range(int from, int to);`

`v.number.positive();`

## Strings
> v.string()

* **required** parameter makes null and empty string  values false 
* **contains** makes sure that String contains exact char combination
* **minLength** makes sure that String is more or equals than minLength

`v.string().required();`

`v.string.contains.("something");`

`v.string.minLength(5);`

## Maps
> v.map()

* **required** parameter makes null value false 
* **sizeof** makes sure map is not bigger certain size 

`v.map().required();`

`v.map().sizeof();`

## Map Content 
> v.map()
 
 * **shape** adds `Map<String, BaseSchema<String>>` type into validator that checks parameters 
inside map 

> Map<String, BaseSchema<String>> schemas = new HashMap<>();
>
> schemas.put("firstName", v.string().required());
>
> schemas.put("lastName", v.string().required().minLength(2));
>
> schema.shape(schemas);

otherwise everything works the same ;-)


 
