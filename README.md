### Execução do serviço
    // subir os serviços zookeeper e kafka
    docker compose up -d

    // subir o serviço rule-engine
    gradle bootrun

    Para adicionar os itens na fila pode usar o plugin do kafka no próprio IntelliJ
    Enviar para o tópico 'rules'
### Exemplo de json para adicionar na fila
```
{
    "temperature": 35,
    "timestamp": "2025-06-29T00:40:00Z",
    "location": {
        "lat": -23.57,
        "lon": -46.64
    },
    "deviceId": "sensor-01"
}
``` 