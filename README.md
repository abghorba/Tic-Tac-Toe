# Tic-Tac-Toe
An implementation of Tic-Tac-Toe which is played on the command line.

<h2> Video Demo </h2>
https://youtu.be/gv5gskxMY5M

<h2> How to Play! </h2>
First, choose the type of game you want to play.
If you want to play vs another person, run TicTacToe.java!
If you want to play vs the minimax computer, run MiniMaxTicTacToe.java!
If you want to play vs the alpha-beta computer, run AlphaBetaTicTacToe.java!

The grid is as follows with the coordinates:

        (1,1) | (1,2) | (1,3)
        ---------------------
        (2,1) | (2,2) | (2,3)
        ---------------------
        (3,1) | (3,2) | (3,3)

To make your move, simply type in on the command line:

        rowNumber colNumber

You may even type them on different lines such as:

        rowNumber
        colNumber

Acceptable values for rowNumber and colNumber are the integers 1, 2, and 3!


<h2> Gameplay: </h2>

If you run TicTacToe.java, you can play with another person!
Example game of Player vs. Player:

        AI.Player 1: Do you want to be X or O? (X/O)
        X

          |   |
        ----------
          |   |
        ----------
          |   |

        X enter the row and column:
        1 1
        X |   |
        ----------
          |   |
        ----------
          |   |

        O enter the row and column:
        1 2
        X | O |
        ----------
          |   |
        ----------
          |   |

        X enter the row and column:
        3 3
        X | O |
        ----------
          |   |
        ----------
          |   | X

        O enter the row and column:
        2 3
        X | O |
        ----------
          |   | O
        ----------
          |   | X

        X enter the row and column:
        2 1
        X | O |
        ----------
        X |   | O
        ----------
          |   | X

        O enter the row and column:
        1 3
        X | O | O
        ----------
        X |   | O
        ----------
          |   | X

        X enter the row and column:
        3 1
        X | O | O
        ----------
        X |   | O
        ----------
        X |   | X

        The winner is: X
        Do you want to play again? (y/n)


If you run MinimaxTicTacToe or AlphaBetaTicTacToe, you play against the computer! Try to beat the computer!
Example game of Player vs. Computer:

        Do you want to be X or O? (X/O)
        X

          |   |
        ----------
          |   |
        ----------
          |   |

        X enter the row and column:
        1 1
        X |   |
        ----------
          |   |
        ----------
          |   |

        Computer's turn.

        X |   |
        ----------
          | O |
        ----------
          |   |

        X enter the row and column:
        3 1
        X |   |
        ----------
          | O |
        ----------
        X |   |

        Computer's turn.

        X |   |
        ----------
        O | O |
        ----------
        X |   |

        X enter the row and column:
        2 3
        X |   |
        ----------
        O | O | X
        ----------
        X |   |

        Computer's turn.

        X | O |
        ----------
        O | O | X
        ----------
        X |   |

        X enter the row and column:
        3 2
        X | O |
        ----------
        O | O | X
        ----------
        X | X |

        Computer's turn.

        X | O |
        ----------
        O | O | X
        ----------
        X | X | O

        X enter the row and column:
        1 3
        X | O | X
        ----------
        O | O | X
        ----------
        X | X | O

        Its a DRAW!
        Do you want to play again? (y/n)
