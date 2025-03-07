…or create a new repository on the command line
echo "# demo-jpa" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/ricardohc/demo-jpa.git
git push -u origin main


…or push an existing repository from the command line
git remote add origin https://github.com/ricardohc/demo-jpa.git
git branch -M main
git push -u origin main


{
"name": "Juan Perez",
"salary": 666,
"creationDate": "2025-03-07T01:34:00",
"job": {
"jobId": 2,
"jobname": ""
}
}
