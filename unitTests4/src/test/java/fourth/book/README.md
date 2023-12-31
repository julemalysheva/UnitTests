## Unit-тесты (семинары)
### Урок 4. Зависимости в тестах

**Задание 1. Ответьте письменно на вопросы:**

1)  Почему использование тестовых заглушек может быть полезным при написании модульных тестов?

Использование тестовых заглушек может быть полезным при написании модульных тестов, потому что они позволяют 
изолировать тестируемый объект от зависимостей, фокусируясь только на его логике. Заглушки могут заменять сложные 
или медленные компоненты, такие как внешние сервисы или базы данных, чтобы тесты были более предсказуемыми и стабильными.
Кроме того, заглушки позволяют контролировать входные данные, тестируя разные сценарии.

2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?

Как стабы, так и моки подходят для этой цели.
Для проверки вызова метода с определенными аргументами можно использовать стабу (stub). 
Стабы фиксируют ожидаемое поведение вызова метода. 
Мок объект создает запрограммированную имитацию объекта, в которой можно проверять вызовы методов и передаваемые 
аргументы. Заглушки предоставляют возможность задать ожидаемое поведение и проверить, что тестируемый код 
взаимодействует правильно с этой заглушкой.

3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?

Следует использовать фейковые объекты. Фейки - это заглушки, которые реализуют упрощенную логику и 
используются для предоставления заранее заданных результатов, не зависящих от внешних факторов. 
Они позволяют контролировать возвращаемые значения и исключения, чтобы протестировать различные сценарии 
без необходимости вызывать реальный код.
Однако, помимо фейков, для возвращения определенного значения или исключения также могут быть использованы моки или стабы. 
Это зависит от конкретной ситуации

4) Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или базой данных?

Думаю, в этом случае лучшее всего подойдут моки. Они позволяют точно имитировать поведение внешних систем, 
возвращая заданные данные, как если бы они были получены от API или БД.
Но для имитации взаимодействия с внешним API или базой данных, могут быть использованы различные типы тестовых заглушек, 
в зависимости от требований тестирования и особенностей ситуации:

1. Фейк (Fake): Фейк может быть хорошим вариантом, если нужно предоставить упрощенную реализацию взаимодействия 
с внешним API или базой данных. Это может быть полезно, если нужно предоставить статические или заранее заданные
данные без доступа к реальному внешнему ресурсу. 

2. Мок (Mock): Мок может быть использован, если хотим создать контролируемое взаимодействие с внешним API или 
базой данных. Мок может имитировать методы и поведение, чтобы предоставить ожидаемые результаты или проверить 
ожидаемые вызовы. Мок может использоваться для тестирования различных сценариев и проверки, 
что код правильно взаимодействует с внешним ресурсом.

3. Стаб (Stub): Стаб также может быть вариантом для имитации взаимодействия с внешним API или базой данных. 
Стаб предоставляет заранее заданные данные и результаты для тестирования, не требуя реального взаимодействия 
с внешним ресурсом. Он может быть полезен, если нужно предоставить определенные сценарии или результаты 
для тестирования определенных частей кода.

4. Шпион (Spy): Шпион может использоваться для записи и анализа взаимодействия с реальным внешним API или базой данных.
Шпион может быть полезен, если хотим проверить, какие методы были вызваны и с какими аргументами, 
или хотим получить информацию о реальных вызовах методов. 
Шпион может использоваться совместно с фейком, моком или стабом, чтобы предоставить функциональность записи 
и анализа взаимодействия.

Конкретный выбор типа тестовой заглушки для имитации взаимодействия с внешним API или базой данных зависит 
от требований тестирования и особенностей ситуации.


**Задание 2.**

У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.

* Используем MockitoExtension и @Mock/@InjectMocks аннотации для создания фиктивного хранилища книг
* Задаем имитационное поведение с помощью when().thenReturn()
* Вызываем методы в BookService и утверждаем, что возвращаемое значение соответствует поддельному ответу
* Также мы использовали Mockito.verify для проверки, что методы мока были вызваны с правильными аргументами.

Это позволяет нам тестировать книжный сервис изолированно, не требуя реального хранилища книг.
Эти тесты проверяют правильность работы класса BookService, используя мок-объект BookRepository.