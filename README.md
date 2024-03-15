☑️ ENTITIES :-
Admin: Represents a library administrator with attributes like name, userName, etc.
Branch: Represents a library branch with attributes like branchName, address, etc.
Book: Represents a book in the library system with attributes like title, author, category, etc.
User: Represents a user of the library system
Transaction : Represent a assosiate entity between user and book

☑️ RELATIONSHIP ➡️
Admin - Branch ▶️ One TO Many
User - Branch  ▶️ One TO Many
User - Book  ▶️ Many TO Many
Book - Branch  ▶️ One TO Many
