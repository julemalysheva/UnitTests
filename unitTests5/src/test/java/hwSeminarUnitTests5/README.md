## Unit-тесты (семинары)
### Урок 5. Другие виды тестирования

**Задание 1.** Представьте, что вы работаете над разработкой простого приложения для записной книжки, которое позволяет пользователям добавлять, редактировать и удалять контакты.
Ваша задача - придумать как можно больше различных тестов (юнит-тесты, интеграционные тесты, сквозные тесты) для этого приложения. Напишите название каждого теста, его тип и краткое описание того, что этот тест проверяет.

1. Юнит-тесты:
    - testAddContact - проверка корректности функции addContact в изоляции, тест на функцию добавления контакта.
    - testEditContact - проверка корректности функции editContact в изоляции, тест на функцию редактирования контакта.
    - testDeleteContact - проверка корректности функции deleteContact в изоляции, тест на функцию удаления контакта.
    - testAddContactInvalidName - проверяет, что при добавлении контакта с пустым или некорректным именем, возникает исключение IllegalArgumentException.
    - testAddContactExistingContact - проверяет, что при добавлении существующего контакта, возникает исключение DuplicateContactException.
    - testAddContactInvalidEmail - проверяет, что при добавлении контакта с некорректным адресом электронной почты, возникает исключение InvalidEmailException.
    - testAddContactInvalidPhone - проверяет, что при добавлении контакта с некорректным номером телефона, возникает исключение InvalidPhoneException.
    - testAddContactDuplicateId - проверка обработки исключения при добавлении контакта с уже существующим идентификатором.
   - testEditContactNullId - проверка обработки попытки редактирования контакта с нулевым идентификатором.
   - testDeleteContactNullId - проверка обработки попытки удаления контакта с нулевым идентификатором.
   - testAddContactInvalidDateOfBirth - проверка обработки неправильной даты рождения контакта.

2. Интеграционные тесты:
    - testRepositoryAddContact - интеграционный тест на добавление контакта через репозиторий для проверки взаимодействия с БД.
    - testRepositoryGetContacts - интеграционный тест на получение списка контактов из БД.
    - testServiceRepositoryInteraction - интеграционный тест на взаимодействие сервиса и репозитория.
    - testRepositoryDuplicateIdException - интеграционный тест на обработку исключения при попытке добавить контакт с уже существующим идентификатором.
   - testUIAddContactInvalidInput - проверяет, что при добавлении контакта через пользовательский интерфейс с некорректными данными, отображается сообщение об ошибке.
   - testUIEditContactInvalidInput - проверяет, что при редактировании контакта через пользовательский интерфейс с некорректными данными, отображается сообщение об ошибке.
   - testUIAddContactInvalidEmail - проверяет, что при добавлении контакта через пользовательский интерфейс с некорректным адресом электронной почты, отображается сообщение об ошибке.
   - testUIAddContactInvalidPhone - проверяет, что при добавлении контакта через пользовательский интерфейс с некорректным номером телефона, отображается сообщение об ошибке.

3. Сквозные тесты:
    - testUIAddContact - сквозной тест на добавление контакта через пользовательский интерфейс (UI) - проверка всего приложения от UI до DB.
    - testUIEditContact - сквозной тест на редактирование контакта через пользовательский интерфейс (UI) - проверка всего приложения от UI до DB.
    - testUIDeleteContact - сквозной тест на удаление контакта через пользовательский интерфейс (UI) - проверка всего приложения от UI до DB.
    - testFullContactLifecycle - проверяет полный цикл работы с контактом: создание контакта, его редактирование и последующее удаление. 
   Этот тест может включать взаимодействие с пользовательским интерфейсом и проверку базы данных.

***

**Задание 2.** Ниже список тестовых сценариев. Ваша задача - определить тип каждого теста (юнит-тест, интеграционный тест, сквозной тест) и объяснить, почему вы так решили.

*""Проверка того, что функция addContact корректно добавляет новый контакт в список контактов"".*
- это юнит-тест. Он проверяет отдельную функцию addContact в изоляции и не взаимодействует с другими компонентами системы или внешними зависимостями.

*""Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов"".*
- это интеграционный тест. Он проверяет взаимодействие между пользовательским интерфейсом и бэкэндом системы, а именно, что данные корректно отображаются в пользовательском интерфейсе после добавления контакта.

*""Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление"".*
- это сквозной тест. Он проверяет полный путь пользователя в системе, включая создание, редактирование и удаление контакта. Этот тест включает взаимодействие с разными компонентами системы, такими как пользовательский интерфейс и база данных, и проверяет, что все компоненты взаимодействуют корректно.