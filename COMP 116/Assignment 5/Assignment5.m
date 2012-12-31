%% Assignment 5 - Aaron Davis
% I pledge that I recieved nor gave authorized assistance on this
% assignment.
%% (1) Say (in text) how many pits and peaks were in map.
pitlist = findPits(map);
[pits, col] = size(pitlist);
% There are 57 pits in the map.
peaklist = findPits(-map);
[peaks, col] = size(peaklist);
% There are 273 peaks in the map.
%% (2) Display map as a grayscale image, with pits and peaks marked 
%% on top of it. You can use the following code to do this:
pits = findPits(map);
peaks = findPits(-map);
imagesc(map); colormap(gray); axis equal
hold on
plot(pits(:,2),pits(:,1),'ro');
plot(peaks(:,2),peaks(:,1),'g+');
hold off
%% (3) Display map as a grayscale image with the path of a single raindrop
%% drawn on it as discussed above. The resulting image should look
%% something like the image at right (of course, it will be different
%% depending on what pixel was clicked.
calcPath(map);
%% (4) Compute the flow matrix as discussed above. Plot an image
%% of all of the pixels that have flow greater than 200. The output
%% image should be like the image at right
clf
mapflow1 = flowmap(map, 200);
[row1, col1] = size(mapflow1);
points1 = [];
for j = 1:row1;
    for k = 1:col1;
        if mapflow1(j,k) == 1;
            points1 = [points1; j k ];
        end
    end
end
plot(points1(:,2), points1(:,1),'.b');
title('map of flow>200');
%% (5) Plot an image of all the pixels that have flow greater than
%% 1000. The output image should be like the image at right.
clf
mapflow2 = flowmap(map, 1000);
[row2, col2] = size(mapflow2);
points2 = [];
for j = 1:row2;
    for k = 1:col2;
        if mapflow2(j,k) == 1;
            points2 = [points2; j k ];
        end
    end
end
plot(points2(:,2), points2(:,1),'.b');
title('map of flow>1000');

%% Conclusion
% This assignment was far from any of the others we've done so far, and I
% enjoyed how in depth and involved it was. I relly feel like it's a
% legitimate program and it taught me many concepts including clear, concise
% coding, makign sure to include clear comments, and loops.