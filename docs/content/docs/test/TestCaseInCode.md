---
title: Test case in code
type: docs
---

# Test case in code

Правда о тест кейсе исторически хранилась в TMS.\
Поддерживать актуальной информацию сразу в двух местах не самое достойное занятие, а увеличение кол-ва автоматизированных
кейсов остро поставило вопрос о стоимости этого занятия.

Чтобы упростить поддержку, появилась возможность держать источник правды в коде, синхронизируя всю информацию в TMS.

## Как синхронизировать свой тест с TMS?

Чтобы это сделать, тесту нужно проставить аннотацию `@ExternalId(UUID)`, где UUID - сгенерированный на клиенте случайный UUID.

## FAQ

Q: Когда происходит синхронизация\
A: После попадания кода в ветку develop

Q: Как выглядит такие тесты в TMS\
A: Становятся read-only

## Stubs: tests without implementation

Если тестами хочется управлять из кода уже сейчас, а их написание отложить, то можно просто создать стабы. \
Стабы это тесты со всей нужной информацией (аннотации, шаги), но не выполняющие никаких действий и проверок.

Чтобы на уровне TMS отличать автоматизированные тесты, от стабов, добавлены специальные типы с приставкой `-stub`
(см. `com.avito.report.model.Kind`)

Тип `manual` - специально для указания ручных тестов, которые не планируется автоматизировать,
но хочется держать рядом с автотестами в коде.

### Stubs generation

> TODO вынести в opensource для демонстрации

Для упрощения переноса в проекте есть модуль `:test-generator`, который по указанию списка id тесткейсов генерирует код тестов-стабов.
