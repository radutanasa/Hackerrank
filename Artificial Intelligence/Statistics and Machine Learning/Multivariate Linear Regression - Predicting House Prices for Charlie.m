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

function [J, grad] = computeCost(theta, X, y, lambda)
    m = length(y);
    grad = zeros(size(theta));
    J = 0;
    sumVal = 0;
    for i=1:m
        sumVal += (theta'*(X(i,:))' - y(i)).^2;
    end
    J = sumVal/m + lambda/(2*m) * (sum(theta(2:end).^2));
    grad = ((theta'*X' - y')*X/m)' + lambda/m * [0; theta(2:end)];
end

X = [ones(length(y), 1) X];

initial_theta = zeros(size(X, 2), 1);
# no regularization
lambda = 0;
options = optimset('GradObj', 'on', 'MaxIter', 500);
[theta, J, exit_flag] = fminunc(@(t)(computeCost(t, X, y, lambda)), initial_theta, options);

testSetSize = str2num(input("", "s"));
testSet = zeros(testSetSize, cols);
for i=1:testSetSize
    testSet(i,:) = str2num(input("","s"));
end

testSet = [ones(testSetSize, 1) testSet];
prediction = testSet*theta;

for i=1:testSetSize
    printf("%f\n", prediction(i,1))
end