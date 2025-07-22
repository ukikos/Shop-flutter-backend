# Shop-flutter-backend

Серверная часть готова к разверытыванию в Docker после предварительной настройки переменных среды (URL, логин и пароль БД).

## Развертывание
#### Настройка переменных среды
Переменные среды расположены по пути ```.env```

#### Создание и запуск контейнеров
Выполнить в корне директории проекта:
```
docker compose up
```

#### Остановка контейнеров
```
docker container stop $(docker ps -q -f name=shop) 
```

#### Запуск контейнеров
```
docker container start $(docker ps -a -q -f name=shop)
```

#### Удаление контейнеров и томов
```
docker container rm $(docker ps -a -q -f name=shop)
docker volume rm $(docker volume ls -q -f name=shop)
```
