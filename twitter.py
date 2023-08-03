import tweepy
import time

# Insira suas chaves de acesso da API do Twitter
consumer_key = 'SEU_CONSUMER_KEY'
consumer_secret = 'SEU_CONSUMER_SECRET'
access_token = 'SEU_ACCESS_TOKEN'
access_token_secret = 'SEU_ACCESS_TOKEN_SECRET'

def autenticar_twitter():
    auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
    auth.set_access_token(access_token, access_token_secret)
    return tweepy.API(auth)

def obter_trending_topics(api, woeid=1, limite=10):
    try:
        trends = api.get_place_trends(id=woeid)
        return trends[0]['trends'][:limite]
    except tweepy.TweepError as e:
        print("Ocorreu um erro ao buscar os trending topics:", e)
        return []

def exibir_trending_topics(trending_topics):
    print("Trending topics:")
    for index, trend in enumerate(trending_topics, 1):
        print(f"{index}. {trend['name']}")

def escolher_localizacao(api):
    locais_disponiveis = api.available_trends()
    print("Locais disponíveis para buscar os trending topics:")
    for index, local in enumerate(locais_disponiveis, 1):
        print(f"{index}. {local['name']}")
    
    while True:
        try:
            opcao = int(input("Escolha o número do local desejado: "))
            if 1 <= opcao <= len(locais_disponiveis):
                return locais_disponiveis[opcao - 1]['woeid']
            else:
                print("Opção inválida. Tente novamente.")
        except ValueError:
            print("Entrada inválida. Digite o número correspondente ao local.")

def main():
    api = autenticar_twitter()
    while True:
        print("\n1. Trending topics em todo o mundo")
        print("2. Trending topics em uma localização específica")
        print("3. Sair")
        opcao = input("Escolha uma opção: ")
        
        if opcao == '1':
            trending_topics = obter_trending_topics(api)
            exibir_trending_topics(trending_topics)
        elif opcao == '2':
            woeid = escolher_localizacao(api)
            trending_topics = obter_trending_topics(api, woeid)
            exibir_trending_topics(trending_topics)
        elif opcao == '3':
            print("Saindo...")
            break
        else:
            print("Opção inválida. Tente novamente.")

if __name__ == "__main__":
    main()
