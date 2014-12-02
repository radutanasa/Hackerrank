# Enter your code here. Read input from STDIN. Print output to STDOUT

trainingSetSize = str2num(input("", "s"));

cols = trainingSetSize(1,1);
rows = trainingSetSize(1,2);
X = zeros(rows, cols);
y = zeros(rows, 1);
for i=1:rows
    line = str2num(input("", "s"));
    X(i,:) = line(1,1:cols);
    y(i) = line(1,cols+1);
end
