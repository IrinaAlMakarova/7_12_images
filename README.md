## Coroutines в Android

### Задача №1. Remove & likes
Легенда
Используя код и сервер из лекции, реализуйте в проекте функциональность удаления и проставления лайков. Для этого нужно отредактировать PostViewModel и PostRepositoryImpl:

// PostViewModel
fun likeById(id: Long) {
    TODO()
}

fun removeById(id: Long) {
    TODO()
}

// PostRepositoryImpl
override suspend fun removeById(id: Long) {
    TODO("Not yet implemented")
}

override suspend fun likeById(id: Long) {
    TODO("Not yet implemented")
}
Логика работы:

Сначала модифицируете запись в локальной БД или удаляете.
Затем отправляете соответствующий запрос в API (HTTP).
Не забудьте об обработке ошибок и кнопке Retry в случае, если запрос в API завершился с ошибкой (в том числе в случае отсутствия сетевого соединения*).

Примечание*: не обязательно перезапускать сервер. Достаточно отключить сеть в шторке телефона/эмулятора.

## Flow
### Задача №1. New Posts
Легенда
Используйте код и сервер из лекции, реализуйте в проекте следующие требования:

1. Посты, загружаемые в фоне через getNewer, не должны отображаться сразу в RecyclerView. Вместо этого должна появляться плашка, как в ВКонтакте.

2. При нажатии на плашку происходит плавный скролл RecyclerView к самому верху. Должны отображаться загруженные посты. Сама плашка после этого удаляется.
Реализация
Посмотрите гайдлайны Material Design: есть ли там элементы со схожим поведением. Если есть, используйте их, если нет, предложите свою реализацию.

Подсказки:

Попробуйте предусмотреть реализацию, при которой в getNewer не будут запрашиваться посты, которые уже есть у вас в локальной БД. Возможно, вам придётся по-другому считать количество: например, с помощью запроса в БД. Там как раз есть пример с COUNT.

## Загрузка и отображение изображений
### Задача №1. Photo
Описание

У вас есть пример загрузки изображений, теперь мы реализуем их отображение. Давайте посмотрим, как это сделано в приложении ВКонтакте.

Если в посте есть картинка, то она отображается внутри этого поста:
![](https://raw.githubusercontent.com/IrinaAlMakarova/7_12_images/refs/heads/main/pic/01.png)
Если кликнуть на картинку, она открывается на весь экран:
![](https://raw.githubusercontent.com/IrinaAlMakarova/7_12_images/refs/heads/main/pic/02.png)
Ваша задача — реализовать подобное поведение через фрагменты, когда при клике на картинку открывается новый фрагмент, на котором изображение выводится на весь экран.

При оформлении AppBar достаточно, чтобы фон был чёрный и картинка отображалась по центру.

Важно: URL картинки будет: API_URL/media/. Т. е. если с сервера вам вернулся: d7dff806-4456-4e35-a6a1-9f2278c5d639.png, то полный URL будет: http://10.0.2.2:9999/media/d7dff806-4456-4e35-a6a1-9f2278c5d639.png.