![Build Status](https://github.com/borisgrafx/Metric-to-IEC-converter/actions/workflows/main.yml/badge.svg?branch=develop) (develop)
![Build Status](https://github.com/borisgrafx/Metric-to-IEC-converter/actions/workflows/main.yml/badge.svg?branch=main) (main)
# Metric-to-IEC-converter
Сервис, конвертирующий Килобайты в Кибибайты, Мегабайты в Мибибайты и т.д.
# Запуск программы
Клонируйте репозиторий:
``` console
$ git clone https://github.com/borisgrafx/Metric-to-IEC-converter
```
Соберите docker образ:
``` console
$ sudo docker build -t metric-to-iec-converter .
```
Запустите его:
``` console
$ sudo docker run -p 8080:8080 metric-to-iec-converter
```
# Как пользоваться
1. Введите объём данных формата [Число] [RU/EN размерность в метрическом или бинарном формате] [Число] ...
2. Наслаждайтесь результатом конвертации!
# Пример
Для входных данных:
``` console
10 Пб 999 тб 228 гБ 3 КБ
```
Получим: 
``` console
9 PiB 787 TiB 757 GiB 347 MiB 920 KiB 952 B
```