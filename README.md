### Функциональные компоненты режима **Castles**:

1. **Игровая карта**:
   - Содержит замки команд и точки контроля, захват которых приносит ресурсы и бонусы.

2. **Замок**:
   - Центральная структура команды. Если замок разрушен — команда проигрывает. Можно улучшать замок и строить укрепления за золото.

3. **Золото**:
   - Основной ресурс, добываемый через убийства, захват точек и выполнение задач. Используется для улучшений, строительства и покупки предметов.
   - **Сундучки**: На карте периодически появляются сундуки, в которых можно найти золото и другие полезные предметы, такие как ресурсы для постройки, зелья и редкие улучшения. Игроки должны собирать их как можно быстрее, чтобы получить преимущество.

4. **Точки контроля**:
   - Захватываемые зоны, дающие золото, улучшения и стратегические преимущества.

5. **Игровые классы**:
   - Игроки выбирают роли (танк, воин и др.) и могут улучшать их за золото.

6. **Тактическая механика**:
   - Команды координируют действия, распределяют ресурсы, планируют атаки и защиту (ну это база базированная).

7. **Система улучшений**:
   - Улучшение оружия, замка, обороны и способностей за золото.

8. **Количество игроков**:
   - В каждой команде от 5 до 10 игроков, в зависимости от карты.

9. **Мелкие механики**:
   - **Крафт**: Некоторые предметы и постройки можно крафтить из собранных ресурсов.
   - **Точки возрождения**: Игроки могут возрождаться ближе к передовой, если контролируют определённые точки на карте.
   - **Бонусы за серию убийств**: Игроки, совершающие серии убийств, получают временные улучшения, такие как усиление атаки или скорости.

10. **Игра заканчиваеться когда...: **:
   - Игра завершается, когда замок одной из команд разрушен. Побеждает команда, сохранившая свой замок.

### Команды режима **Castles**

1. **/join <команда>**
   - **Функционал**: Позволяет игроку присоединиться к указанной команде. Доступно только до начала игры. Если игра уже началась, команда не может быть изменена.

2. **/leave**
   - **Функционал**: Позволяет игроку покинуть свою текущую команду и вернуться в лобби для выбора новой команды, если игра ещё не началась.

3. **/status**
   - **Функционал**: Показывает текущий статус игры, включая количество игроков в каждой команде, статус игры (Started, NotStarted, Full) и другие важные сведения.

4. **/upgrade**
   - **Функционал**: Открывает интерфейс улучшения, позволяя игроку тратить золото на улучшения оружия, брони и замка. Игроки могут улучшать свои классы и способности.
     
5. **/report**
   - **Функционал**: Отправляет сообщение о состоянии игры или проблемы, с которыми столкнулся игрок. Сообщения отправляются администратору для разрешения ситуации.

# Игпа начнеться по истечению времени и если в комнате один игрок таймер не пойдет.

### Заключение
Эти команды позволяют игрокам эффективно взаимодействовать с режимом **Castles**, управлять своим прогрессом и командной игрой.



#### 1. **Команды для персонала**
   # Пока ток это готов то есть все что после этого сообщения
- **/addstructure <имя структуры>**
  - Команда для добавления новой структуры. Игрок выделяет область с помощью WorldEdit, и команда сохраняет эту область как часть структуры с указанным именем.

- **/menu**
  - Меню с разными  очередями . Когда нажимаешь на очередь у тебя есть выбор между командыми . Команду можно изменить только пока игра не начата у игры есть статусы Started , NotStarted , Full . При Started уже незя менять команду , а еще игрокт в лоби в menu видят что данная игра пока закрыта.     
    NotStarted - можно выбирать команду и заходить в меню. При Full - комната с ожиданием начала игры закрыта , но все кто к комнате еще могут менять команду.

- **/setstructure <имя структуры>**
  - Команда для установки точки спауна структуры. Игрок указывает, где именно должна спавниться структура.

- **/registerevent /registerevent <event> <Структура> <условие>**
  - Команда для регистрации событий, при которых будет строиться структура. Указывает, что при определенном событии (например, при активации редстоуна или при игроке входящем в зону) должна строиться структура.

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
