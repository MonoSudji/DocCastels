### Основные компоненты и их работа

#### 1. **Команды плагина**

- **/addstructure <имя структуры>**
  - Команда для добавления новой структуры. Игрок выделяет область с помощью WorldEdit, и команда сохраняет эту область как часть структуры с указанным именем.

- **/setstructure <имя структуры>**
  - Команда для установки точки спауна структуры. Игрок указывает, где именно должна появляться структура.

- **/registerevent /registerevent <event> <Структура> <условие>**
  - Команда для регистрации событий, при которых будет строиться структура. Указывает, что при определенном событии (например, при активации редстоуна или при игроке входящем в зону) должна строиться структура, если выполняется указанное условие.

### Примеры использования

1. **Добавление структуры:**
   - Игрок выделяет область с помощью WorldEdit топорика.
   - Выполняет команду `/addstructure <имя структуры>`, чтобы сохранить выделенную область как структуру.

2. **Установка точки спауна:**
   - Игрок стоит на месте, где он хочет спаунить структуру.
   - Выполняет команду `/setstructure <имя структуры>`, чтобы установить точку спауна для структуры.

3. **Регистрация события:**
   - Программист регистрирует обработчик события с помощью команды `/registerevent <event> <Структура> <условие>` `PS() : Услови -  чтобы не выполнять строение здания при каждом событии>`.
   - Когда событие происходит, проверяется условие, и если оно выполняется, строится структура.

4. **Для чего:**
   -Это API будет использовано в качестве реализации воздвежения структуры по блочно.

### Структура JSON-файлов

- **JSON-файл для хранения структур**
  - Содержит данные о структурах, их частях, материалах и координатах(В формате X , Y , Z , Material).
