# REF: https://teamtreehouse.com/library/algorithms-sorting-and-searching/searching-names/code-for-linear-search

import sys

from load import load_strings

names = load_strings(sys.argv[1])

# Passed in list must be larger than these search names(100)
search_names = [
    "Lindsay Burgess",
    "Yvette Webb",
    "Percy White",
    "Carl Colon",
    "Nina Mason",
    "Kristopher King",
    "Rodolfo Wallace",
    "Andrew Green",
    "Lillie Fernandez",
    "Iris Perkins",
    "Carlton Ford",
    "Michele Mcbride",
    "Karl Arnold",
    "Jonathan Strickland",
    "Pam Saunders",
    "Isaac Stanley",
    "Greg Curry",
    "Camille Burke",
    "Ronald Quinn",
    "Pauline Chambers",
    "Meghan Paul",
    "Debra Ortiz",
    "Arthur Duncan",
    "Francis Garrett",
    "Sidney Sandoval",
    "Merle Nichols",
    "Jerald Ellis",
    "Gladys Chapman",
    "Shawn Bowers",
    "Kristina Pierce",
    "Jimmie Hernandez",
    "Kelley Lyons",
    "Ricky Clarke",
    "Pablo Brown",
    "Bryant Bryant",
    "Phillip Mcgee",
    "Leticia Ward",
    "Michael Shaw",
    "Dwight Lewis",
    "Franklin Fox",
    "Muriel Houston",
    "Gabriel Bridges",
    "Daisy Soto",
    "Allen Conner",
    "Lester Boone",
    "Brent Boyd",
    "Ada Fisher",
    "Jasmine Glover",
    "Tracey Gutierrez",
    "Terrence Austin",
    "Tom Massey",
    "Wilbur Bush",
    "Lorena Weaver",
    "Chester Guzman",
    "Ivan Miller",
    "Hugo Garza",
    "Sabrina Matthews",
    "Jeremy Newman",
    "Kyle Chandler",
    "Krystal Byrd",
    "Bernard Reed",
    "Wayne Elliott",
    "Audrey Cunningham",
    "Ed Moreno",
    "Luther Gilbert",
    "Lorenzo Murray",
    "Neil George",
    "Andre Crawford",
    "Alex Hart",
    "Tim Nash",
    "Rogelio Payne",
    "Marcella Mann",
    "Hector Perry",
    "Pat Roberts",
    "Marlene Gonzalez",
    "Eleanor Ross",
    "Jane Parsons",
    "Kelly Tyler",
    "Kevin Newton",
    "Doyle Jefferson",
    "Karla Meyer",
    "Darnell Salazar",
    "Molly Warren",
    "Carrie Ruiz",
    "Jan Frazier",
    "Heather Mckenzie",
    "Marcus Grant",
    "Phyllis Mckinney",
    "Antonio Estrada",
    "Judith Pratt",
    "Craig Carson",
    "June Wilson",
    "Bonnie Hubbard",
    "Bradford Mullins",
    "Earnest Harris",
    "Hilda Copeland",
    "Joel Osborne",
    "Preston Rivera",
    "Christian Blair",
    "Kim Hill",
]


def index_of_item(collection, target):
    for i in range(0, len(collection)):
        if target == collection[i]:
            return i

    return None


for n in search_names:
    index = index_of_item(names, n)
    print(index)
