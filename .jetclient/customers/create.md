```toml
name = 'create'
method = 'GET'
url = 'http://localhost:8080/products/custom'
sortWeight = 1000000
id = '8c3c8891-6409-4e37-8215-fde47a6f14e3'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "name" : "test",
  "price" : "200"
}'''
```
