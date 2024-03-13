import re
import os

# Function to prompt user for input
def prompt(message):
    return input(message)

# Prompt user for the LeetCode problem URL
url = prompt('Please input the LeetCode problem URL: ')

# Extract problem name from the URL
match = re.match(r'https://leetcode.com/problems/(.*)', url)
if match:
    problem_name = match.group(1).split('/')[0]

    # Attempt to create directory for the problem
    try:
        os.mkdir(problem_name)
        print(f"{problem_name} directory created.")
    except FileExistsError:
        print(f"{problem_name} directory already exists.")
    except Exception as e:
        print(f"Error creating {problem_name} directory:", e)

    try:
        # Creates a new file
        with open(f'./{problem_name}/Solution.java', 'w') as fp:
            pass
        print(f"Solution.java created.")
    except FileExistsError:
        print(f"Solution.java already exists.")
    except Exception as e:
        print(f"Error creating {problem_name} directory:", e)

else:
    print("Invalid URL format.")
