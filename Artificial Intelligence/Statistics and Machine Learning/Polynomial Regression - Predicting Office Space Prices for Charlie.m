# Enter your code here. Read input from STDIN. Print output to STDOUT

function [polyX indices] = multinom(X, degree)
  [m,n] = size(X);
    
  if(degree == 1)       
    polyX = X;
    indices = zeros(n,1);
  else
    polyX = [];
    [remaining_PolyX prev_indices] = multinom(X,degree-1);
 
    if(prev_indices(1) == 0)
      offset = 0;
      for i = 1:numel(prev_indices)
        prev_indices(i) = n-offset;
        offset = offset + 1;
       end
    else
      for i = 1:numel(prev_indices)
        total = 0;
        for j = i:numel(prev_indices)
          total = total + prev_indices(j);
        end
        prev_indices(i) = total;
      end
    endif
 
    for i = 1:n
      feature = X(:,i);
      for j = 0:(prev_indices(i)-1)
        polyX = [polyX X(:,i).*remaining_PolyX(:,size(remaining_PolyX,2)-j)];
      end
    end
 
    indices = prev_indices;
  endif
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

[X_poly_2 indices] = multinom(X, 2);
[X_poly_3 indices] = multinom(X, 3);
X_poly = [ones(size(X, 1), 1) X X_poly_2 X_poly_3];

initial_theta = zeros(size(X_poly, 2), 1);
lambda = 0.2;
options = optimset('GradObj', 'on', 'MaxIter', 500);
[theta, J, exit_flag] = fminunc(@(t)(computeCost(t, X_poly, y, lambda)), initial_theta, options);

testSetSize = str2num(input("", "s"));
testSet = zeros(testSetSize, cols);
for i=1:testSetSize
    testSet(i,:) = str2num(input("","s"));
end

[testSet_poly_2 indices] = multinom(testSet, 2);
[testSet_poly_3 indices] = multinom(testSet, 3);
testSet_poly = [ones(size(testSet, 1), 1) testSet testSet_poly_2 testSet_poly_3];

prediction = testSet_poly*theta;

for i=1:testSetSize
    printf("%f\n", prediction(i,1))
end